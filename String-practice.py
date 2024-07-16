import re
def string_practice(str):
    match = re.search(r'\d*\.?\d{0,2}$', str)
    number_str=match.group(0)
    if "." in number_str:
        integer_part,decimal_part=number_str.split(".")
        if len(decimal_part)<2:
            decimal_part=decimal_part+"0"
    else:
        integer_part=number_str
        decimal_part="00"
    if not integer_part:
        integer_part="0"

    return f'{integer_part}.{decimal_part}'
# string_practice("abc22.1")
print(string_practice("abc.22"))
print(string_practice("abc0.2233"))
print(string_practice("abc.21"))
print(string_practice("abc"))
print(string_practice("abc222"))