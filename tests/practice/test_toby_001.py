"""
String-practice

有一个不定长度的String，其中前面是字母，后边是数字,例如："abcd123.456", 要求写一个方法得到其中的数字以String的形式返回,数字保留小数点后两位， 不四舍五入，截去多余小数.例如："abcd123.456"，得到"123.45" 如果数字没有小数点,要得到两位为0的小数，例如："abcd123"，得到"123.00".
"""
import string

import pytest


def check_digit(char: str):
    if char in string.digits or char == '.':
        return char
    return None


def convert_string_formal(text: str) -> str:
    digit_str = ''.join(list(filter(lambda x: check_digit(x), text)))
    digit_str_tmp = f'{float(digit_str):.3f}'
    _integer, _decimal = digit_str_tmp.split('.')
    return f'{_integer}.{_decimal[:2]}'


test_data = [
    ('abcd123.456', '123.45'),
    ('abcd123.4', '123.40'),
    ('abcd123.', '123.00'),
    ('abcd123', '123.00'),
    ('abcd000.0001', '0.00'),
    ('abcd000.1', '0.10'),
    ('abcd003', '3.00'),
    ('abcd000', '0.00'),
]


def main():
    for data, _ in test_data:
        print(f'{data=}')
        print(f'{convert_string_formal(data)=}')


@pytest.mark.parametrize('text,expected', test_data)
def test_practice(text, expected):
    print(f'{"*" * 10}')
    print(f'{text=}')
    print(f'{expected=}')
    actual = convert_string_formal(text)
    print(f'{actual=}')
    assert actual == expected


if __name__ == '__main__':
    pytest.main(['-vqs', __file__])
    # main()
