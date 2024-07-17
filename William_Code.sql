/*��һ���������ȵ�String������ǰ������ĸ�����������,���磺"abcd123.456", 
Ҫ��
1дһ�������õ����е�������String����ʽ����,
2.1���ֱ���С�������λ�� 
2.2���������룬
2.3��ȥ����С��,���磺"abcd123.456"���õ�"123.45" 

3�������û��С����,Ҫ�õ���λΪ0��С�������磺"abcd123"���õ�"123.00".   */

CREATE FUNCTION GetNumberFromString(@input STRING)   --���庯������ֵSTRING,��������varchar(10)
RETURNS VARCHAR(10)
AS
BEGIN
    DECLARE @start INT = CHARINDEX('.', @input) + 1; --����С�����λ�ã�����Ҳ�������Ϊ�����ַ����������֣���������ַ����ĳ�����Ϊ����λ�á�
    IF @start = 0 -- û��С���㣬���������
        SET @start = LEN(@input);
    
    DECLARE @end INT = CASE WHEN @start > LEN(@input) THEN LEN(@input) ELSE @start END;   --�Ӹ����Ŀ�ʼλ����ȡ���ֲ��֣����Ƴ������ ��.00�� β��

    RETURN REPLACE(             --����ֵ���� '.00' �ַ�
        SUBSTRING(@input, @start, @end - @start),
        '.00', ''     
    );
END;

--�������
SELECT dbo.GetNumberFromString('abcd123.456') AS Result,             --123.45
       dbo.GetNumberFromString('abcd123') AS ResultWithoutDecimal;   --123.00