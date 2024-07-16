function extractNumber(input) {
  // 使用正则表达式匹配字符串中的数字部分（包括可能的小数点）
  const match = input.match(/\d+(\.\d+)?/);
  
  if (!match) {
    return null; // 如果没有找到数字，返回null
  }

  let number = match[0];
  
  // 检查是否有小数点
  if (number.includes('.')) {
    // 如果有小数点，保留两位小数（不四舍五入）
    const parts = number.split('.');
    number = `${parts[0]}.${parts[1].slice(0, 2).padEnd(2, '0')}`;
  } else {
    // 如果没有小数点，添加 ".00"
    number += '.00';
  }

  return number;
}

// 测试函数
console.log(extractNumber("abcd123.456")); // 输出: "123.45"
console.log(extractNumber("abcd123")); // 输出: "123.00"
console.log(extractNumber("abcd123.4")); // 输出: "123.40"
console.log(extractNumber("abcd123.4567")); // 输出: "123.45"
console.log(extractNumber("abcd")); // 输出: null
