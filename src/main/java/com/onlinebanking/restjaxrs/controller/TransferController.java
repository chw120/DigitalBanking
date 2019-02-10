package com.onlinebanking.restjaxrs.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.onlinebanking.restjaxrs.dto.TransferDto;
import com.onlinebanking.restjaxrs.model.Account;
import com.onlinebanking.restjaxrs.model.AccountType;
import com.onlinebanking.restjaxrs.model.User;
import com.onlinebanking.restjaxrs.service.TransactionService;
import com.onlinebanking.restjaxrs.service.TransactionServiceImpl;
import com.onlinebanking.restjaxrs.service.UserService;
import com.onlinebanking.restjaxrs.service.UserServiceImpl;


@Path("/v1/transfer")
public class TransferController {
	private static final Logger logger = Logger.getLogger(TransferController.class.getName());
	
	private UserService userService;
	private TransactionService transactionService;
	
	public TransferController() {
		
	}
	
	@POST
	@Path("/onetime")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response transfer(TransferDto input) {
		userService = new UserServiceImpl();
		transactionService = new TransactionServiceImpl();
		User user = userService.findUserByEmail(input.getUserEmail());
		User recipient = userService.findUserByEmail(input.getRecipientEmail());
		if (recipient == null || !recipient.getAccount().getAccountNumber().equals(input.getRecipientAccountNo())) {
			return Response.status(400).entity("Cannot find recipient or recipient account.").build();
		}		
		if (!user.getAccount().getAccountNumber().equals(input.getUserAccountNo())) {
			return Response.status(400).entity("Cannot find associated card.").build();
		}
		Account accountTo = recipient.getAccount();
		Account accountFrom = user.getAccount();
		System.out.println(accountTo.getAuid() + " " + accountTo.getAccountBalance());
		if (accountFrom.getAccountType() == AccountType.DEBIT && accountFrom.getAccountBalance().compareTo(input.getAmount()) == -1) {
			return Response.status(400).entity("Insufficient Balance.").build();
		}
		boolean res = transactionService.transferOnetime(accountFrom, accountTo, input.getAmount());
		return Response.status(200).entity("Transfer successfully.").build();
		
	}
	
	@GET
	@Path("/info")
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() { 
		userService = new UserServiceImpl();
		List<User> users = userService.findAll();
		StringBuilder sb = new StringBuilder();
		for (User u : users) {
			sb.append(u.getUserId() + " " + u.getEmail() + " " + u.getAccount().getAccountNumber() + " " + u.getAccount().getAccountBalance() + "\n");
		}
        return " Welcome!\n" + sb.toString();
    }
	
}
