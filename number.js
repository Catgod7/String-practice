function getNumber(str) {
  // 使用正则表达式匹配数字部分
  const number = str.match(/\d+(\.\d+)?/)
  if (!number) {
    return '字符串中无数字'
  } else {
    // parseFloat将'数字'转换成数字，使用toFixed()方法格式化数字到小数点后两位
    return parseFloat(number[0]).toFixed(2)
  }
}

getNumber('a12') // 输出12.00
getNumber('abc12.55') // 输出12.55
getNumber('abc12.15134') // 输出12.15
getNumber('abc') // 输出字符串中无数字