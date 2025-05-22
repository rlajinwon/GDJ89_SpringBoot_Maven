<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>수동 이벤트 FullCalendar</title>

  <link href="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.css" rel="stylesheet" />
  <script src="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.8/index.global.min.js"></script>

  <style>
    #calendar {
      max-width: 900px;
      margin: 40px auto;
    }
  </style>
</head>
<body>

<h2 style="text-align:center;">날짜 클릭 시 메모 입력</h2>
<div id="calendar"></div>

<script>
  document.addEventListener('DOMContentLoaded', function () {
    const calendarEl = document.getElementById('calendar');

    const calendar = new FullCalendar.Calendar(calendarEl, {
      initialView: 'dayGridMonth',
      locale: 'ko',
      headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,listWeek'
      },
      selectable: true, // 날짜 선택 가능하게 함
      dateClick: function(info) {
        const dateStr = info.dateStr;
        const memo = prompt(`${dateStr}에 입력할 메모를 작성하세요:`);

        if (memo) {
          calendar.addEvent({
            title: memo,
            start: dateStr,
            allDay: true
          });
        }
      }
    });

    calendar.render();
  });
</script>

</body>
</html>
