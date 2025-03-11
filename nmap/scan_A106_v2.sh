#!/bin/bash

nmap -sn 172.16.0.0/24 | grep "scan report" | tr -d '()' > ip.txt

awk '{print $NF}' ip.txt > ip2.txt

echo "IP;TCP_OPEN;UDP_OPEN" >> scan-result_2.csv
while read line;
do
    echo $line
    echo "$line;$(nmap -F $line | grep '/tcp' | grep open | wc -l);$(sudo nmap -sU -F $line | grep '/udp' | grep open | wc -l)" >> scan-result_2.csv
done < ip2.txt

rm *.txt