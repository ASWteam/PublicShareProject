// DTO
var schedule = {
  id:0,
  title:'',
  start:'',
  end:'',
  color:''
};

// 전역변수
var EVENT = [];

var URL = 'http://localhost:8080/2zo-calendar/calendar';

function select(year, month) {
  console.log(year, month);

  $.ajax({
    url: URL,
    type: 'get',
    dataType:'json',
    data: {year:year, month:month},
    success: function (events) {
      EVENT = events;
      console.log(EVENT);
      $('#calendar').fullCalendar( 'removeEventSource', EVENT);
      $('#calendar').fullCalendar( 'addEventSource', EVENT);
    }
  });
}

// 이벤트 클릭 > 조회화면 > 수정클릭> 수정화면 > 완료
// 드래그앤드랍
// 리사이즈
function update(schedule) {
  $.ajax({
    url: URL,
    type: 'post',
    dataType:'json',
    data: {schedule:schedule},
    success: function (events) {
      console.log(events);
      // EVENT = events;
      // console.log(EVENT);
      // $('#calendar').fullCalendar( 'removeEventSource', EVENT);
      // $('#calendar').fullCalendar( 'addEventSource', EVENT);
    }
  });

}

//save클릭 > 저장완료
function write(schedule) {
  $.ajax({
    url: URL,
    type: 'post',
    dataType:'json',
    data: {schedul:schedul},
    success: function (events) {
      EVENT = events;
      console.log(EVENT);
      $('#calendar').fullCalendar( 'removeEventSource', EVENT);
      $('#calendar').fullCalendar( 'addEventSource', EVENT);
    }
  });
}

function remove(id) {
  $.ajax({
    url: URL,
    type: 'delete',
    dataType:'json',
    data: {id:id},
    success: function (events) {
      console.log(events);
      var index = EVENT.findIndex(function (element, index, array) {
        return element.id === id;
      });

      EVENT.splice(index, 1);
      $('#calendar').fullCalendar( 'removeEventSource', EVENT);
      $('#calendar').fullCalendar( 'addEventSource', EVENT);
    }
  });
}
