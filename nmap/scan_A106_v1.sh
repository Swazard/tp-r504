#!/bin/bash

nmap -sn 172.16.0.0/24 | grep "scan report" | tr -d '()' > ip.txt

awk '{print $NF}' ip.txt > ip2.txt

while read line;
do
    echo "$line,$(nmap -F $line | grep "/tcp" | grep open | wc -l)" >> scan-result_1.csv
done < ip2.txt

rm *.txt