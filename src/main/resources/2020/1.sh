#!/bin/bash
cat day04.txt |
sed 's/^$/|/' |
awk 'BEGIN{ORS=" "}{print}' |
sed 's/|/\n/g' | # At this point each passport is in one line
sed 's/^/ /' | # add space to the first line
egrep ' byr:(19[2-9][0-9]|200[012])' |
egrep ' iyr:(201[0-9]|2020)' |
egrep ' eyr:(202[0-9]|2030)' |
egrep ' hgt:(1[5678][0-9]|19[0123])cm| hgt:(59|6[0-9]|7[0-6])in' |
egrep ' hcl:#[0-9a-f]{6}( |$)' |
egrep ' ecl:(amb|blu|brn|gry|grn|hzl|oth)' |
egrep ' pid:[0-9]{9}( |$)' |
wc