# coding: utf-8

from socket import *
import datetime
import time

def main():
    #name of UDP server on computer
    serverName = 'localhost'
    port = 2014
    clientSocket = socket(AF_INET, SOCK_DGRAM)
    data = 'ping'

    #set 10 times of pings
    LastPing = 10
    count = 0
    clientSocket.settimeout(1)
    print ("Attempting to send " , count , "messages" )
    
    # feed
    while count  < LastPing:
        count = count + 1
        startTime = time.time()
        print("The current time is: " , startTime , " and this is message number: " , count)
        clientSocket.sendto(data.encode('ascii'), (serverName, port))

        try:
            newData, clientAddress = clientSocket.recvfrom(1024)
            # count round-trip time (RTT)
            RTT = ((time.time()) - startTime)
            print (newData)
            print (RTT)
            
        except timeout:
            print(" Request timed out ")
        
        except Exception as e:
            print(e)
    
    print ("the program is done")

main()


