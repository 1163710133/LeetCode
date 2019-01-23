public class Solution13 {
    public int romanToInt(String s) {
        char[] temp = s.toCharArray();
        int result = 0;
        for (int i = 0; i < temp.length; i++) {
            switch (temp[i]) {
                case 'M':
                    result += 1000;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'C':
                    if (i + 1 < temp.length && temp[i + 1] == 'M') {
                        i++;
                        result += 900;
                    } else if (i + 1 < temp.length && temp[i + 1] == 'D') {
                        i++;
                        result += 400;
                    } else {
                        result += 100;
                    }
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'X':
                    if (i + 1 < temp.length && temp[i + 1] == 'C') {
                        i++;
                        result += 90;
                    } else if (i + 1 < temp.length && temp[i + 1] == 'L') {
                        i++;
                        result += 40;
                    } else {
                        result += 10;
                    }
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'I':
                    if (i + 1 < temp.length && temp[i + 1] == 'X') {
                        i++;
                        result += 9;
                    } else if (i + 1 < temp.length && temp[i + 1] == 'V') {
                        i++;
                        result += 4;
                    } else {
                        result += 1;
                    }
                    break;
            }
        }
        return result;
    }

}
