<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>食堂信息维护</title>
  <style>
    .container {
      width: 50%;
      margin: auto;
      padding: 20px;
    }

    .form-group {
      margin-bottom: 15px;
    }

    .form-group label {
      display: block;
    }

    .form-group input, .form-group textarea {
      width: 100%;
      padding: 8px;
      margin-top: 5px;
    }

    .submit-button {
      background-color: #4CAF50;
      color: white;
      padding: 10px 15px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }
  </style>
</head>
<body>

<div class="container">
  <h2>食堂信息维护</h2>

  <form action="UpdateRestaurantServlet" method="post">
    <div class="form-group">
      <label for="cafeteriaName">食堂名称:</label>
      <input type="text" id="cafeteriaName" name="cafeteriaName">
    </div>

    <div class="form-group">
      <label for="description">简介:</label>
      <textarea id="description" name="description"></textarea>
    </div>

    <div class="form-group">
      <label for="openingHours">营业时间:</label>
      <input type="text" id="openingHours" name="openingHours">
    </div>

    <button type="submit" class="submit-button">提交</button>
  </form>
</div>

</body>
</html>
