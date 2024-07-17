import re

def extract_number(s):
    
    match = re.search(r'(\d+(\.\d+)?)', s)
    if match:
        number_str = match.group(0)
        if '.' in number_str:
            integer_part, decimal_part = number_str.split('.')
            decimal_part = decimal_part[:2]  # 截取小数点后两位
            return f"{integer_part}.{decimal_part.ljust(2, '0')}"
        else:
            return f"{number_str}.00"
    else:
        return "0.00"

if __name__=='__main__':
    print(extract_number('abcd123.456'))