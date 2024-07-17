import re


def extract_number(s):
    # 使用正则表达式找到字符串中的数字部分
    match = re.search(r'\d+(\.\d+)?', s)
    if match:
        # 如果没有小数点，则添加一个.00来确保格式化时保留两位小数
        number_str = match.group()
        if '.' not in number_str:
            number_str += '.00'
        else:
            # 如果已经包含小数点，但小数部分长度超过2，则截断
            parts = number_str.split('.')
            if len(parts[1]) > 2:
                number_str = f"{parts[0]}.{parts[1][:2]}"
        return number_str
    else:
        # 如果没有找到数字，返回空字符串或指定值
        return ""

    # 测试函数


print(extract_number("abcd123.456"))  # 输出: 123.45
print(extract_number("abcd123"))  # 输出: 123.00
print(extract_number("Caster45292124.987654321"))  # 输出: 45292124.98
