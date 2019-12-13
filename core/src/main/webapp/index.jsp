<%@include file="include/header.jsp" %>

        <form action ="${pageContext.request.contextPath}/table" method ="post" enctype = "multipart/form-data">


            <div class ="form-row align-items-center m-2">
              <div class="col-auto m-2">
                <label for="xmlLoad">Select xml</label>
                <input type="file" accept=".xml" class="form-control-file" id="xmlFile"
                    name="xmlFile" value="${xmlFile}">
              </div>

              <div class="form-group col-auto m-2">
                    <label for="xmlType">Xml type</label>
                    <select name="xmlType">
                        <option value="Author" selected>Author</option>
                        <option value="Calendar">Calendar</option>
                        <option value="Catalog">Catalog</option>
                        <option value="Event">Event</option>
                        <option value="Journal">Journal</option>
                        <option value="Newspaper">Newspaper</option>
                    </select>
               </div>

              <div class="col-auto m-2">
                <button type="submit" class="btn btn-primary">Print table</button>
              </div>
            </div>
        </form>

        <c:if test="${publications != null}">

            <table class="table table-hover table-sm table-bordered">
                <thead class="table-primary">
                    <tr>
                        <c:forEach var="field" items="${fieldsWithGetter}">
                            <th>${field.getName()}</th>
                        </c:forEach>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="publ" items="${publications}">
                        <tr>
                            <c:forEach var="field" items="${fieldsWithGetter}">
                                 <th>${getMethodByFieldName.get(field.getName()).invoke(publ).toString()}</th>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </c:if>

        <c:if test="${error != null}">
            <div class="alert alert-danger" role="alert">
               Check input! Error message: ${error.getMessage()}
            </div>
        </c:if>

<%@include file="include/footer.jsp" %>