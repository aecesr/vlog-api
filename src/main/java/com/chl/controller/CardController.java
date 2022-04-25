package com.chl.controller;

import com.chl.common.ResponseResult;
import com.chl.common.ResultCode;
import com.chl.model.Card;
import com.chl.util.DataUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: mqxu
 **/
@RestController
@RequestMapping(value = "api")
public class CardController {

    @GetMapping("cards")
    public List<Card> getCard() {
        return DataUtil.initCards();
    }
}
