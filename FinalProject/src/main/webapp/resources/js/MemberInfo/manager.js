$(function(){
	$("#searchID").on("keyup", function(){
		let searchbar = $('#searchID').prop('value');
		$.ajax({
			url: '/selectManager',
			type: 'post',
			data: {id: searchbar},
			success: function(data){
				var html = '';
				$.each(data, function(index , item){
					html += '<tr>';
					html += '<td>'+item.id+'</td>';
					html += '<td>';
					html += '<select>';
					html += '<option selected="selected" hidden>' + item.grade + '</option>';
					html += '<option value="admin">admin</option>';
					html +=	'<option value="member">member</option>';
					html += '</select>';
					html += '</td>';
					html += '<td>';
					html += '<button type="button" class="updateBtn">수정</button> ';
					html += '<button type="button" class="deleteBtn">삭제</button>';
					html += '</td>';
					html += '</tr>';
				});
				$("#tbody").empty();
				$("#tbody").append(html);
				clickUpdateBtn();
				clickDeleteBtn();
			},
			error: function(){
				alert("error");
			}
		});
	});
	
	clickUpdateBtn();
	clickDeleteBtn();
});

function clickUpdateBtn(){
	$(".updateBtn").on("click", function(){
		let selectbox = this.parentElement.previousElementSibling.firstElementChild;
		let id = this.parentElement.previousElementSibling.previousElementSibling.innerHTML;
		let grade = selectbox.options[selectbox.selectedIndex].value;
		
		let cfm = confirm("수정하시겠습니까?");
		if(cfm == true){
			$.ajax({
				url: '/updateManager',
				type: 'post',
				data: {id:id, grade:grade},
				success: function(){
					location.href="/manager.onlyAdmin"
				},
				error: function(){
					alert("error");
				}
			});
		}
		
	});
}

function clickDeleteBtn(){
	$(".deleteBtn").on("click", function(){
		
		let id = this.parentElement.previousElementSibling.previousElementSibling.innerText;
		let cfm = confirm("정말로 삭제하시겠습니까?");
		
		if(cfm == true){
			$.ajax({
				url: '/deleteManager',
				type: 'post',
				data: {id:id},
				success: function(){
					location.href="/manager.onlyAdmin"
				},
				error: function(){
					alert("error");
				}
			});
		}
	});
}
