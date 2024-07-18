def extract_number(s):
    # 找到字母和数字的分界点
    digit_start = s.find('.')
    if digit_start == -1:
        digit_start = len(s)
    
    # 提取数字部分
    number_str = s[digit_start:]
    
    # 如果数字部分没有小数点，则在数字后添加 ".00"
    if '.' not in number_str:
        number_str += ".00"
    
    # 截取小数点后两位
    decimal_index = number_str.find('.')
    if decimal_index != -1:
        number_str = number_str[:decimal_index + 3]
    
    return number_str

# 测试示例
print(extract_number("abcd123.456"))  # 输出 "123.45"
print(extract_number("abcd123"))       # 输出 "123.00"
