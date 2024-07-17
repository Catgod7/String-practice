print('有一个不定长度的String，其中前面是字母，后边是数字,例如："abcd123.456", 要求写一个方法得到其中的数字以String的形式返回,数字保留小数点后两位， 不四舍五入，截去多余小数,例如："abcd123.456"，得到"123.45" 如果数字没有小数点,要得到两位为0的小数，例如："abcd123"，得到"123.00".')
print('请输入字符串：')
input_string = input()

digit_idx = 0
if input_string:
    for idx, char in enumerate(input_string):
        if char.isdigit():
            digit_idx = idx
            break
    else:
        print("输入不包含数字")
        exit()

    new_str = input_string[digit_idx:]
    if '.' not in new_str:
        new_str += '.00'
    part1 = new_str.split('.')[0]
    part2 = new_str.split('.')[1]
    if len(part2) >= 2:
        part2 = part2[:2]
    else:
        part2 += '0' * (2 - len(part2))

    answer = part1 + '.' + part2
    print(answer)
else:
    print('输入为空')