from decimal import Decimal


def num2money_format(change_number):

    format_word = ["元",
                   "拾", "佰", "仟", "万",
                   "拾", "佰", "仟", "亿",
                   "拾", "佰", "仟", "万",
                   "拾", "佰", "仟"]

    format_word_decimal = ['分', '角']

    format_num = {'0': "零", '1': "壹", '2': "贰", '3': "叁", '4': "肆", '5': "伍", '6': "陆", '7': "柒", '8': "捌", '9': "玖"}

    res = []

    if '.' not in change_number:

        k = len(change_number) - 1
        for i in change_number:
            res.append(format_num[i])
            res.append(format_word[k])
            k = k - 1

    elif '.' in change_number:
        float_2_change_num = Decimal(float(change_number)).quantize(Decimal("0.00"))
        # 如果输入的字符串有“.”，则将其转换为浮点数后，四舍五入取两位小数

        depart = str(float_2_change_num).split('.')
        int_part = depart[0]  # 整数部分
        decimal_part = depart[1]  # 小数部分

        k = len(int_part) - 1
        for i in int_part:  # 整数部分
            res.append(format_num[i])
            res.append(format_word[k])
            k = k - 1

        m = len(decimal_part) - 1
        for i in decimal_part:  # 小数部分
            res.append(format_num[i])
            res.append(format_word_decimal[m])
            m = m - 1

    return ''.join(res)


your_money = input()
result = num2money_format(your_money)
print(result)
