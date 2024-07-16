function stringPractice(s) {
    var match = s.match(/\d+(\.\d+)?/);
    if (match) {
        var str = match[0];
        var [number, decimal= ''] = str.split('.');
        decimal = (decimal + '00').slice(0, 2);
        return `${number}.${decimal}`;
    } else {
        return "0.00";
    }
}

console.log(stringPractice("erewabcd123.4500006"));
console.log(stringPractice("awbvcbcd125553.11"));
console.log(stringPractice("abcvbdcd123.4"));
console.log(stringPractice("abwrwercd"));
