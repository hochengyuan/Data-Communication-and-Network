# coding: utf-8

# use IMAP to recieve gmail
import imaplib 

# connect to IMAP of Gmail
messageServer = imaplib.IMAP4_SSL ('imap.gmail.com', 993)

# type in username
username = input('Please enter your Gmail username:') 
# type in password
password = input('Please enter your Gmail password:') 

# login
messageServer.login(username, password) 

state , count = messageServer.select('Inbox') 

# Grab the first email 'count[0]' from my inbox.
state , data = messageServer.fetch(count[0], '(UID BODY[TEXT])')
print(data[0][1])


messageServer.close()

messageServer.logout()


