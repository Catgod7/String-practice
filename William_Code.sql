/*有一个不定长度的String，其中前面是字母，后边是数字,例如："abcd123.456", 
要求
1写一个方法得到其中的数字以String的形式返回,
2.1数字保留小数点后两位， 
2.2不四舍五入，
2.3截去多余小数,例如："abcd123.456"，得到"123.45" 

3如果数字没有小数点,要得到两位为0的小数，例如："abcd123"，得到"123.00".   */

CREATE FUNCTION GetNumberFromString(@input STRING)   --定义函数输入值STRING,返回类型varchar(10)
RETURNS VARCHAR(10)
AS
BEGIN
    DECLARE @start INT = CHARINDEX('.', @input) + 1; --查找小数点的位置，如果找不到则认为整个字符串都是数字，并计算出字符串的长度作为结束位置。
    IF @start = 0 -- 没有小数点，添加两个零
        SET @start = LEN(@input);
    
    DECLARE @end INT = CASE WHEN @start > LEN(@input) THEN LEN(@input) ELSE @start END;   --从给定的开始位置提取数字部分，并移除多余的 “.00” 尾部

    RETURN REPLACE(             --返回值加上 '.00' 字符
        SUBSTRING(@input, @start, @end - @start),
        '.00', ''     
    );
END;

--结果测试
SELECT dbo.GetNumberFromString('abcd123.456') AS Result,             --123.45
       dbo.GetNumberFromString('abcd123') AS ResultWithoutDecimal;   --123.00