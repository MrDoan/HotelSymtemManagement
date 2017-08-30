package com.eva.phase2.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.eva.phase2.beans.dto.hotel.HotelDTOIn;
import com.eva.phase2.entity.Hotel;

public final class ValidationUtil {
	public static final boolean isValidEmailAddress(String email) {
		if (email == null || email.isEmpty() || !email.contains("@"))
			return false;

		String simpleEmailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(simpleEmailRegex);
		Matcher m = p.matcher(email);

		return m.matches();
	}

	public static final boolean isValidPhoneNumber(String phone) {
		if (phone == null || phone.isEmpty())
			return false;

		// String japanesePhoneRegex = "/^\\(?(\\+81|0)([-\\d \\(\\)]{9,12})$";
		String regexStr = "^[0-9]{10}$";
		Pattern p = Pattern.compile(regexStr);
		Matcher m = p.matcher(phone);

		return m.matches();
	}

	public static final boolean isValidAddress(String address) {
		if (address == null || address.isEmpty())
			return false;

		// Change minimum address length to check wheter the input address is
		// acceptable
		return address.length() >= 5;
	}

	public static final boolean isValidImageUrl(String imageUrl) {
		if (imageUrl == null)
			return false;

		if (imageUrl.isEmpty())
			return true;

		// Change this regex if it is not acceptable!
		String imageUrlRegex = "[a-zA-Z0-9]+(,[a-zA-Z0-9]+.[a-zA-Z]{3})?";
		Pattern p = Pattern.compile(imageUrlRegex);
		Matcher m = p.matcher(imageUrl);

		return m.matches();
	}

	public static final List<String> isValidHotelInfo(HotelDTOIn hotelInfo) {
		List<String> errors = new ArrayList<String>();

		if (!isValidEmailAddress(hotelInfo.getEmail())) {
			errors.add("Invalid email: " + hotelInfo.getEmail());
		}

		if (!isValidAddress(hotelInfo.getAddress())) {
			errors.add("Invalid address:" + hotelInfo.getAddress() + ", minimum characters is 5");
		}

		// if (!isValidImageUrl(hotelInfo.getImagePath())) {
		// errors.add("Invalid image path format: " + hotelInfo.getImagePath());
		// }

		if (!isValidPhoneNumber(hotelInfo.getPhone())) {
			errors.add("Invalid phone number! Phone number must be matches 10-digit numbers only");
		}

		return errors;
	}

	public static final List<String> isValidHotelInfo(HotelDTOIn hotelInfo, Hotel hotel) {
		List<String> errors = new ArrayList<String>();

		if (hotel == null)
			return errors;

		if (hotel.getName().equalsIgnoreCase(hotelInfo.getName())) {
			errors.add("Hotel name: " + hotelInfo.getName() + " is already exists!");
		}

		if (hotel.getEmail().equals(hotelInfo.getEmail())) {
			errors.add("Hotel email : " + hotelInfo.getEmail() + " is already exists!");
		}

		return errors;
	}
}
