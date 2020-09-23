$("#btnUpdateBuilding").click(function(){
        var data = {};

        var buildingTypes = [];

        var formData = $('#form_edit').serializeArray();

        formData.forEach(element => {
          if (element.name == 'buildingTypes'){
            buildingTypes.push(element.value);
          } else {
            data[""+element.name+""] = element.value;
          }
        });

        data['buildingTypes'] = buildingTypes;

        console.log(data);
        $.ajax({
          type:  "PUT",

          url: "http://localhost:8080/api/building",

          data: JSON.stringify(data),

          dataType: "json",

          contentType: "application/json",

          success: function (response) {
        	  console.log(response);
          },

          error: function(error){
            console.log(error)
          }
        });

      });