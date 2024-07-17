import re


def string_practice(str):
    number_str = re.sub(r'[^0-9.]', '', str)
    if "." in number_str:
        integer_part, decimal_part = number_str.split(".")
        if len(decimal_part) < 2:
            decimal_part = "{:0<2}".format(decimal_part)
        else:
            decimal_part = decimal_part[:2]
    else:
        integer_part = number_str
        decimal_part = "00"
    if not integer_part:
        integer_part = "0"

    return f'{integer_part}.{decimal_part}'


print(string_practice("abcd123.456"))
print(string_practice("abc.22"))
print(string_practice("abc0.2233"))
print(string_practice("abc.21"))
print(string_practice("abc"))
print(string_practice("abc222"))
print(string_practice("abc22."))
print(string_practice("abc22.3"))
