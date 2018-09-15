# coding: utf-8

from socket import *
import random
def main():
    serverSocket = socket(AF_INET, SOCK_DGRAM )
    # assign server port as 2014
    serverSocket.bind(('', 2014))
    print("Waiting on port" , 2014)

    while True:
        # random the number
        RandNum = random.randint(0,10)
        # return information and address
        data , clientAddress = serverSocket.recvfrom(1024)
        # captilize the sent line
        newData =  data.upper()

        if RandNum < 4:
            print ("packet lost")
            continue

        serverSocket.sendto(newData, clientAddress)
main()