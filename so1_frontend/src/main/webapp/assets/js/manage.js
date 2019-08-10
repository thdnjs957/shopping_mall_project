

$(document).ready(function() {

    $('#summernote').summernote({
            height: 300,                 // set editor height
            minHeight: null,             // set minimum height of editor
            maxHeight: null,             // set maximum height of editor
            focus: true                  // set focus to editable area after initializing summernote
    });
    
    
    var i = 1;
    
    // 항목추가 버튼 클릭시
      $(".addBtn").click(function(e){
        e.preventDefault();
           //var optionGroup = $(".tOptioNameArea").attr("optionGroup");
     // optionGroup = $(this).parent().find("td:first-child").attr("optionGroup");

      var row = "<tr class='optionTr'><td class='tOptioNameArea' optionGroup="+i+">"
        row += "<input type='text' name='option["+i+"].name' class='option_name' placeholder='예시)색상'/>"
      row += "</td>" +
          "<td class='tOptionValueArea'>" +
          "<div class='dOptionValueArea' style='float:left;'>" +
            "<ul class = 'ulOptionValueArea'>" +
              "<li><input type='text' name='option["+i+"].option_ma[0].value' class='option_value'placeholder='예시)블랙'>" +
              "</li>" +
            "</ul>" +
          "</div>	" +
          "<button class='btn btn-info addValueBtn'>값 추가</button></td><tr>"
      
      i++;
      $("#optionTBody").append(row);

     });
    

        // 삭제버튼 클릭시
        $(document).on("click",".delBtn",function(e){
          e.preventDefault();
            var clickedRow = $(this).parent().parent();
            clickedRow.remove();
        }); 
        
        //값 추가 버튼 클릭시
        $(document).on("click",".addValueBtn",function(e){
          e.preventDefault();
          var lis=$(this).parent().children().find('li').length 
          var target = $(this).parent().find('ul');
          console.log(lis);
          var tag = "<li><input type='text' name='option["+$(this).parent().prev().attr('optionGroup')+"].option_ma["+lis+"].value' class='option_value' placeholder='예시)블랙'></li>";
          target.append(tag);
        }); 
      
        $(document).on("click","#makeOption",function(e){
          
            e.preventDefault();
            
            var ListForValueList = new Array();

            $('.optionTr').each(function(index, item) {
              
          var optionValues = $(item).children().eq(1).find('.option_value');
          
          var valueList = new Array();

          $(optionValues).each(function(index, item) {
            valueList.push($(item).val());
          });

          ListForValueList.push(valueList);
            });	
            
            console.log(ListForValueList);
           
            var r=allPossibleCases(ListForValueList);
            console.log(r);
            
            var tag = ''
              tag += '<table border = "1" style="width:1000px; margin-top:20px;"><thead><th>옵션(품목코드)</th><th>추가금액</th><th>재고수량(-1 입력하시면 재고관리를 하지않습니다.)</th></tr></thead>'
                tag+='<tbody class="collectionOption">'
                
            r.forEach(function(item,index) {
                
              tag+='<tr>'
              tag+='<td> <input type="text" name = "pro_option['+index+'].name" placeholder="옵션(품목코드)" value=" '+item +'" > </td>'
              tag+='<td> <input type="number" name = "pro_option['+index+'].plus" placeholder="추가금액" value=0> </td>'
              tag+='<td> <input type="number" name ="pro_option['+index+'].stock" placeholder="재고수량" value=-1>  </td>'
              tag+='<td>삭제</td>'
              tag+='</tr>'
            
            });
              
               tag+=' </tbody></table>';
            
             $('.optionResult').append(tag);
           
        });
        
        //리스트 모든 조합 
      function allPossibleCases(arr) {
          if (arr.length === 0) {
            return [];
          } 
        else if (arr.length ===1){
        return arr[0];
        }
        else {
            var result = [];
            var allCasesOfRest = allPossibleCases(arr.slice(1)); 
            for (var c in allCasesOfRest) {
              for (var i = 0; i < arr[0].length; i++) {
                result.push(arr[0][i] +'/'+ allCasesOfRest[c]);
              }
            }
            return result;
          }

        }
        
        $(".inp-img").on('change', function(){
            readInputFile(this);
        });
         
       //등록 이미지 등록 미리보기
        function readInputFile(input) {
         console.log($(input));
            if(input.files && input.files[0]) {
                var reader = new FileReader();
                reader.onload = function (e) {
                    $(input).prev().attr('src',e.target.result);
                }
                reader.readAsDataURL(input.files[0]);
            }
        }
       
        $("input[class='img']").click(function(e) {
            e.preventDefault();
            $(this).next().click();
         });

});
