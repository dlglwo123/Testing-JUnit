package com.codestates.homework;

import com.codestates.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RandomPasswordGeneratorTest_V1 {
    static String expectedResult = "";
    static int numberOfUpperCaseLetters = 2;
    static int numberOfLowerCaseLetters = 5;
    static int numberOfNumeric = 2;
    static int numberOfSpecialChars = 1;

    @BeforeEach
    public void init(){
        // 초기값 설정
        expectedResult = RandomPasswordGenerator.generate(numberOfUpperCaseLetters,numberOfLowerCaseLetters,numberOfNumeric,numberOfSpecialChars);
    }

    @DisplayName("실습 3: 랜덤 패스워드 생성 테스트")
    @Test
    public void generateTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.

        // 생성된 패스워드 길이가 입력한 파라미터 숫자의 합과 일치하는지 검증
        int result = 10;
        int expectedLength = expectedResult.length();

        assertEquals(result,expectedLength);

        // 생성된 패스워드의 ‘알파벳 대문자’ 개수가 입력한 파라미터(numberOfUpperCaseLetters ) 숫자와 일치하는지 검증하세요.
        int UpperResultCount = 0;
        for(int i = 0; i < expectedResult.length(); i++){
            char c = expectedResult.charAt(i);
            if(Character.isUpperCase(c)){
                UpperResultCount++;
            }
        }
        assertEquals(numberOfUpperCaseLetters,UpperResultCount);

        // 생성된 패스워드의 ‘알파벳 소문자’ 개수가 입력한 파라미터(numberOfLowerCaseLetters) 숫자와 일치하는지 검증하세요.
        int LowerResultCount = 0;

        for(int i = 0; i < expectedResult.length(); i++){
            char c = expectedResult.charAt(i);
            if(Character.isLowerCase(c)){
                LowerResultCount++;
            }
        }
        assertEquals(numberOfLowerCaseLetters,LowerResultCount);

        //생성된 패스워드의 ‘0 이상인 숫자’의 개수가 입력한 파라미터(numberOfNumeric) 숫자와 일치하는지 검증하세요.
        int oneBetterTanNum = 0;

        for(int i = 0;  i < expectedResult.length(); i++){
            char c = expectedResult.charAt(i);
            if(Character.isDigit(c)){ // Digit을 이용하여 숫자인지 아닌지 확인한다.
                int num = Integer.parseInt(String.valueOf(c));
                if(num >= 0){
                    oneBetterTanNum++;
                }
            }
        }
        assertEquals(numberOfNumeric,oneBetterTanNum);

        //생성된 임시 패스워드의 ‘특수문자’ 개수가 입력한 파라미터(numberOfSpecialChars) 숫자와 일치하는지 검증하세요..
        int SpecialOfNum = 0;

        for(int i = 0; i < expectedResult.length(); i++){
            char c = expectedResult.charAt(i);
            // 공백문자가 아니거나 숫자 문자가 아니거나 공백이 아닐경우 =>즉 특수문자
            if(!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)){
                SpecialOfNum++;
            }
        }
        assertEquals(SpecialOfNum,numberOfSpecialChars);
    }
}
