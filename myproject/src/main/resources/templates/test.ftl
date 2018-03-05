<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>

<!doctype html>
<html lang="en">
<head>
    <title>Test modal</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>
<button class="btn btn-info" data-toggle="modal" data-target="#myModal">Вспывающее окно</button>
<div id="myModal" class="modal fade" tabindex="1">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" data-dismiss="modal">х</button>
                <h4 class="modal-title">Заголовок окна</h4>
            </div>
            <div class="modal-body">Некий текст уведомления</div>
            <div class="modal-footer">
                <button class="btn btn-info" data-dismiss="modal">Save</button>
                <button class="btn btn-danger" data-dismiss="modal">Закрыть</button>
            </div>
        </div>
    </div>
</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script>
    $('#myModal').modal("toggle");

    $('#myModal').on('shown.bs.modal', function (event) {
        // функции
        alert ("Выполенно");
    });
</script>
</html>