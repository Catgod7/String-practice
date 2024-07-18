import re

def extract_number(string):

    # Use regex to find the number part
    match = re.search(r'([0-9]+(\.[0-9]*)?)$', string)

    if match:
        num_str = match.group(1)

        # Split the number into integer and decimal parts
        if '.' in num_str:
            integer_part, decimal_part = num_str.split('.')
        else:
            integer_part, decimal_part = num_str, '00'

        # Ensure decimal part is two digits without rounding
        decimal_part = (decimal_part + '00')[:2]

        return f"{integer_part}.{decimal_part}"
    else:
        return "0.00"


if __name__=='__main__':

    # Test Case
    print(extract_number("abcd123.456"))    # Output: "123.45"
    print(extract_number("abcd123"))        # Output: "123.00"
    print(extract_number("abcd123.4"))      # Output: "123.40"
    print(extract_number("abcd123.6789"))   # Output: "123.67"
    print(extract_number("abcd"))           # Output: "0.00"
