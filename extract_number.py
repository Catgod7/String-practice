def extract_number(string):
    # 找到第一个数字的位置
    for i, char in enumerate(string):
        if char.isdigit():
            start = i
            break
    else:
        return None

    # 找到最后一个数字的位置
    for i, char in enumerate(string[start:]):
        if not char.isdigit() and char != '.':
            end = start + i
            break
    else:
        end = len(string)

    # 提取数字部分
    num_str = string[start:end]

    # 格式化数字
    if '.' in num_str:
        # 有小数点
        return f"{num_str[:num_str.index('.')]}.{num_str[num_str.index('.') + 1:num_str.index('.') + 3]}"
    else:
        # 没有小数点
        return f"{num_str}.00"

# 测试
print(extract_number("abcd123.456"))  # 输出: 123.45
print(extract_number("abcd123"))     # 输出: 123.00