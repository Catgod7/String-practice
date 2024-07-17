def extract_number(input_string):
    # 找到数字开始的位置
    num_start = 0
    for i, char in enumerate(input_string):
        if char.isdigit() or char == '.':
            num_start = i
            break

    # 提取数字部分
    number_part = input_string[num_start:]

    # 如果数字部分没有小数点，则补充两位小数
    if '.' not in number_part:
        number_part += '.00'
    else:
        # 如果有小数点，保留两位小数，不四舍五入
        decimal_index = number_part.index('.')
        decimal_part = number_part[decimal_index:]
        if len(decimal_part) > 3:
            number_part = number_part[:decimal_index + 3]

    return number_part

# 测试示例
input_string1 = "abcd123.456"
input_string2 = "abcd123"
result1 = extract_number(input_string1)
result2 = extract_number(input_string2)

print(result1)  # 输出："123.45"
print(result2)  # 输出："123.00"
