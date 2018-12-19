
    function selectFile(){
        var files = document.getElementById('pic').files;
        if(files.length == 0){
            return;
        }
        var file = files[0];
        //把上传的图片显示出来
        var reader = new FileReader();
        // 将文件以Data URL形式进行读入页面
        reader.readAsBinaryString(file);
        reader.onload = function(f){
            var result = document.getElementById("houseImg");
            var src = "data:" + file.type + ";base64," + window.btoa(this.result);
            $("#h_img").attr("src",src);
        }

    }

  