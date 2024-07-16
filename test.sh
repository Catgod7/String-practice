#!/bin/bash
# function to extract numbers from a string
function extract_numbers() {
    suffix=${1%%[!a-zA-Z0-9.]*}
    suffix=${suffix%%*( )} # remove any trailing spaces
    suffix=${suffix##*[!0-9.]}
    echo "suffix=$suffix"
    if [[ $suffix == *"."* ]]; then
       prefix=${suffix%%"."*}
       decimal=${suffix#*"."}
       decimal=${decimal:0:2}
    else
      prefix=$suffix 
      decimal="00"
    fi
    echo "prefix=$prefix"
    echo "decimal=$decimal"
    printf "%.2f" "$prefix.$decimal"
}

#example usage
input="abcd123.456"
output=$(extract_numbers "$input")
echo "$input -> $output"
input="abcdl23"
output=$(extract_numbers "$input")
echo "$input. -> $output"
