insert into accounts(auid, account_balance, account_number, account_type) values (1000, 9999.99, '122100', 'CREDIT');
insert into accounts(auid, account_balance, account_number, account_type) values (2000, 100.00, '080600', 'CREDIT');

insert into users(user_id, user_name, password, first_name,  middle_name, last_name,  email, phone, account_id) values (1, 'Helen', '123456', 'Helen', '', 'W', 'helen@gm.com', '1234567890', 1000);
insert into users(user_id, user_name, password, first_name,  middle_name, last_name,  email, phone, account_id) values (2, 'CY', '654321', 'CY', '', 'Z', 'cy@gm.com', '0987654321', 2000);

insert into recipients(ruid, account_number, recipient_email, recipient_name, recipientPhone, user_id) values (1, '080600', 'cy@gm.com', '0987654321', 'friend_CY', 1)


