<#ftl encoding='UTF-8'>
<#import 'spring.ftl' as spring>
<@spring.bind "model"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fresh Look</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/main.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="../js/bootstrap.js"></script>
    <!--<script src="../js/main.js"></script-->


</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Fresh Look</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/profile">Profile</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Examples</a></li>
                <li><a href="#">F.A.Q.</a></li>
            </ul>
        </div>
    </div>
</div>
<br/><br/>
<div class="container">
    <div class="row">
        <div class='col-sm-6'>
            <div class="form-group">
                <form method="get" name="scheduleForm" action="/schedule">
                    <input style="color: #000 ;" value="${model.today}" min="${model.min}"type="date" name="date" class="datePicker"/>
                    <input class="btn btn-info" value="Edit Data" type="submit"/>
                </form>
            </div>
        </div>
    </div>

    <div class="row">
        <!--TABLE============================================================================-->


        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>Specialist</th>
                <th class="text-center" colspan="6">${model.today}</th>
            </tr>
            </thead>
        <#list model.users as user>
            <tr>
                <tbody>
                <form method="" name="saveschedule" action="">
                    <td>${user.name}  ${user.surname}</td>
                    <#list  user.schedules as schedules>
                        <#if schedules.status=='BUSY'>
                            <th>
                                <button disabled class="btn btn-danger" value="${schedules.dateTime} ${schedules.master.id}" name="time_id"
                                        type="submit">${schedules.dateTime.toLocalTime()}</button>
                            </th>

                        <#else>
                            <th>
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                                    ${schedules.dateTime.toLocalTime()}
                                </button>
                                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h4 class="modal-title" style="color: #0f0f0f" id="exampleModalLabel">Запись к врачу</h4>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>

                                            </div>
                                            <div class="modal-body">
                                                <p>
                                                    <label style="color: #0f0f0f">Doctor</label>
                                                    <input type="text" value="${schedules.master.name}"/>
                                                </p>

                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                <button type="button" class="btn btn-primary">Save changes</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </th>
                        </#if>
                   <#else>
                        <th>
                            This date is not open for visit
                        </th>
                    </#list>
                    <input type="hidden" style="color: #000 ;" value="${model.today}" type="date" name="date" class="datePicker"/>



                </form>
                </tbody>
            </tr>

        </#list>
        </table>

        <!-- Modal -->



        <!--TABLE============================================================================-->
    </div>

</div>


<footer class="container-fluid text-center" style=" position: relative; top: 100%;">
    <p>
        SUpertext
    </p>
</footer>



</body>

</html>

