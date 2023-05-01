package com.codestates.homework;

import com.codestates.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomPasswordGeneratorTest_V2 {

    int numberOfUpperCaseLetters = 2;
    int numberOfLowerCaseLetters = 5;
    int numberOfNumeric = 2;
    int numberOfSpecialChars = 1;
    String passWard = "";
    int length = 10;

    @BeforeEach
    public void init(){
        passWard = RandomPasswordGenerator.generate(numberOfUpperCaseLetters,
                numberOfLowerCaseLetters,
                numberOfNumeric,
                numberOfSpecialChars);
    }

    @DisplayName("실습 3: 랜덤 패스워드 생성 테스트")
    @Test
    public void generateTest() {

        // 생성된 패스워드 길이가 입력한 파라미터 숫자의 합과 일치하는지 검증
        assertEquals(length,passWard.length());

        // 생성된 패스워드의 ‘알파벳 대문자’ 개수가 입력한 파라미터(numberOfUpperCaseLetters ) 숫자와 일치하는지 검증하세요.
        assertEquals(numberOfUpperCaseLetters,passWard.chars().filter(Character::isUpperCase).count());

        // 생성된 패스워드의 ‘알파벳 소문자’ 개수가 입력한 파라미터(numberOfLowerCaseLetters) 숫자와 일치하는지 검증하세요.
        assertEquals(numberOfLowerCaseLetters,passWard.chars().filter(Character::isLowerCase).count());

        //생성된 패스워드의 ‘0 이상인 숫자’의 개수가 입력한 파라미터(numberOfNumeric) 숫자와 일치하는지 검증하세요.
        assertEquals(numberOfNumeric,passWard.chars().filter(Character::isDigit).count());

        //생성된 임시 패스워드의 ‘특수문자’ 개수가 입력한 파라미터(numberOfSpecialChars) 숫자와 일치하는지 검증하세요..
        assertEquals(numberOfSpecialChars,passWard.chars().filter(
                ch -> (!Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch))
        ).count());
    }
}
