def string_practise(input: str):
    result = []
    decimal_point_exist = False
    decimal_count = 0
    for c in input:
        if c == '.':
            decimal_point_exist = True
            result.append(c)
        if c.isdigit():
            if not decimal_point_exist:
                result.append(c)
            else:
                if decimal_count < 2:
                    result.append(c)
                    decimal_count += 1
                else:
                    break
    if result[0] == '.':
        result.insert(0, '0')
    if not decimal_point_exist:
        result.append('.')
    for i in range(2 - decimal_count):
        result.append('0')
    return ''.join(result)

input = 'abcd123.456'
print(string_practise(input))  # output 123.45
input = 'abcd123'
print(string_practise(input))  # output 123.00
input = 'abcd12.3'
print(string_practise(input))  # output 12.30
input = 'abcd.3456'
print(string_practise(input))  # output 0.34
