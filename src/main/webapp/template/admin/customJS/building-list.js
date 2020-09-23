function assignmentBuilding(buildingId){

        $('#buildingId').val(buildingId);

        openModal();
      }

      function openModal(){
        $('#assignmentBuildingModal').modal();
        
        fetchStaff();
      }

      
      function fetchStaff(){
    	  
    	  $.ajax({
              type:  "GET",

              url: "http://localhost:8080/api/assignmentstaff",
              
              data:{
            	  'id': $('#buildingId').val()
              },
              
              dataType: "json",

              contentType: "application/json",

              success: function (response) {

                var html = '';

                response.forEach(element => {
                  html += '<tr class="even pointer">';
                  html += '<td class="a-center"><input type="checkbox" class="flat" id="staff_'+element.id+'" name="table_records" value="'+element.id+'" '+element.checked+'></td>';
                  html += '<td>'+element.fullName+'</td>';
                  html += '</tr>';
                });
                
                $('#staffList tbody').html(html);
              },

              error: function(error){
                console.log(error);
              }
          });
      }
      
      function toggle(source) {
        checkboxes = document.getElementsByName('chkBuilding');
        
        checkboxes.forEach(element => {
          element.checked = source.checked;
        });
      }

      $('#btnAssignmentBuilding').click(function(){
        
        var data = {};
        var staffs = [];

        data['buildingId'] = $('#buildingId').val();

        var staffs = $('#staffList').find('tbody input[type=checkbox]:checked').map(function(){
          return $(this).val();
        }).get();

        data['ids'] = staffs;

        console.log(data);

        $.ajax({
          type:  "POST",

          url: "http://localhost:8080/api/assignmentstaff",
          
          data: JSON.stringify(data),

          dataType: "json",

          contentType: "application/json",

          success: function (response) {
            console.log(response);
          },

          error: function(error){
            console.log(error);
          }
        });

      });

      $('#btnDeleteBuilding').click(function(e){
 
    	
    		var data = {};

            var buildingLists = $('#buildingList').find('tbody input[type=checkbox]:checked').map(function(){
              return $(this).val();
            }).get();

            data['ids'] = buildingLists;

            console.log(data);

            $.ajax({
              type:  "DELETE",

              url: "http://localhost:8080/api/building",

              data: JSON.stringify(data),

              dataType: "json",

              contentType: "application/json",

              success: function (response) {
                console.log(response);
              },

              error: function(error){
                console.log(error);
              }
            });
      });
      