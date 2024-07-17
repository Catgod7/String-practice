import re

def extract_numbers(input_string):
    # 使用正则表达式找到字符串中的数字部分
    match = re.search(r'(\d+(\.\d+)?)', input_string)
    if match:
        number_str = match.group(1)
        # 如果数字部分包含小数点，则处理小数点后两位
        if '.' in number_str:
            # 找到小数点的位置
            dot_index = number_str.index('.')
            # 保留小数点后两位，不进行四舍五入
            truncated_number_str = number_str[:dot_index + 3]
            # 如果小数位不足两位，则补齐
            while len(truncated_number_str) - dot_index - 1 < 2:
                truncated_number_str += '0'
            return truncated_number_str
        else:
            # 如果数字部分不包含小数点，则加上'.00'
            return number_str + '.00'
    return None

# 测试函数
test_str1 = "abcd123.456"
test_str2 = "abcd123"
print(extract_numbers(test_str1))  # 输出 "123.45"
print(extract_numbers(test_str2))  # 输出 "123.00"
