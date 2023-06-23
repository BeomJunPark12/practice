let index = {

    init:function () {
        $("#btn-save").on("click", ()=> {
            this.save();
        });
    },

    save:function () {
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            name: $("#name").val()
        }
        console.log(data);

        $.ajax({
            type:"POST",
            url:"/auth/joinProc",
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function (resp){
            console.log(resp);
            alert("회원가입이 완료되었습니다.");
            location.href="/";
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    }
}

index.init();