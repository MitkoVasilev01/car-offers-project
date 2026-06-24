package com.vehicles.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException ex, Model model) {
        log.warn("FindCar DDL Intercepted - IllegalArgumentException: {}", ex.getMessage());

        model.addAttribute("errorTitle", "Обявата не е намерена");
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleGeneralException(Exception ex, Model model) {
        log.error("FindCar DDL Intercepted - Unexpected exception: ", ex);

        model.addAttribute("errorTitle", "Повреда по трасето");
        model.addAttribute("errorMessage", "Възникна неочаквана техническа повреда по сървъра. Нашите автотехници вече работят по отстраняването ѝ!");
        return "error";
    }
}