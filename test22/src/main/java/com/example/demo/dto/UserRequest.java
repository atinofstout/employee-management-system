package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.demo.entity.Group1;
import com.example.demo.entity.Group2;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UserRequest implements Serializable {

	//@NotEmpty(message = "社員番号が入力されていません。")
	private Long userid;

	@NotEmpty(message = "パスワードが入力されていません。", groups=Group1.class)
	@Size(min=8,max=20, message="{min}から{max}までの文字を入力してください。", groups=Group2.class)
	private String password;

	@NotEmpty(message = "ユーザー名が入力されていません。", groups=Group1.class)
	private String username;

	@NotEmpty(message = "メールアドレスが入力されていません。", groups=Group1.class)
	@Email(message="メールアドレスの形式で入力してください。", groups=Group2.class)
	private String mail;

	@NotEmpty(message = "電話番号が入力されていません。", groups=Group1.class)
	@Pattern(regexp = "0\\d{1,4}-\\d{1,4}-\\d{4}", message = "電話番号の形式で入力してください。", groups=Group2.class)
	private String phone;

	@NotEmpty(message = "入社日が入力されていません。", groups=Group1.class)
	private String date;


	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}

	public String getMail(){
		return mail;
	}
	public void setMail(String mail){
		this.mail = mail;
	}

	public String getPhone(){
		return phone;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
}
