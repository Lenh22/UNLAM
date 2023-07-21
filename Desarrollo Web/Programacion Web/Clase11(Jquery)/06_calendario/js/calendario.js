document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendario');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      plugins: [ 'dayGrid'],
      locale: 'es',
      events: [
            {
                title: 'Evento',
                start: '2021-06-16',
                end:'2021-06-18'
            },
            {
                title: 'Evento 2',
                start: '2021-07-01'
            },
            {
                title: 'Evento 3',
                start: '2021-07-12'
            }
        ]
    }); 

    calendar.render();
  });