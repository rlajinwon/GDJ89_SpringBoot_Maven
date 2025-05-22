package com.one.app.calendar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/calendar/*")
public class CalendarController {

    @GetMapping("calendarPage")
    public String calendarPage() {
        return "calendar/calendarPage";
    }

    @ResponseBody
    @GetMapping("events")
    public List<Map<String, Object>> getEvents() {
        List<Map<String, Object>> events = new ArrayList<>();

        // 수동 공휴일/이벤트 예시
        Map<String, Object> e1 = new HashMap<>();
        e1.put("title", "[공휴일] 어린이날");
        e1.put("start", "2025-05-05");
        e1.put("color", "red");
        events.add(e1);

        Map<String, Object> e2 = new HashMap<>();
        e2.put("title", "[공휴일] 석가탄신일");
        e2.put("start", "2025-05-12");
        e2.put("color", "red");
        events.add(e2);

        Map<String, Object> e3 = new HashMap<>();
        e3.put("title", "야구 경기");
        e3.put("start", "2025-06-10");
        events.add(e3);

        return events;
    }
    
    
    
    
}
