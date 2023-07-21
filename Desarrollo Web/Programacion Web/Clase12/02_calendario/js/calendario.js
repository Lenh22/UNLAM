document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendario');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      plugins: [ 'dayGrid'],
      locale: 'es',
      events: [
            {
                title: 'Curso 1',
                start: '2021-06-23',
                end:'2021-06-24'
            },
            {
                title: 'Curso 2',
                start: '2021-06-28',
                end:'2021-06-30'
            },
            {
                title: 'Curso 3',
                start: '2021-07-2',
                end:'2021-07-4'
            }
        ]
    }); 

    calendar.render();
  });