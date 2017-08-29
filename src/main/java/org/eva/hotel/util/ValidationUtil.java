package org.eva.hotel.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eva.hotel.beans.dto.hotel.HotelDTOIn;

public final class ValidationUtil {
	public static final boolean isValidEmailAddress(String email) {
		if (email == null || email.isEmpty() || !email.contains("@")) return false;

		String simpleEmailRegex = "[a-zA-Z][a-zA-Z0-9]*@[a-zA-Z0-9]+";
		Pattern p = Pattern.compile(simpleEmailRegex);
		Matcher m = p.matcher(email);

		return m.matches();
	}

	public static final boolean isValidPhoneNumber(String phone) {
		if (phone == null || phone.isEmpty()) return false;

		// Google search Japanese phone number format and replace this !
		String japanesePhoneRegex = "/^\\(?(\\+81|0)([-\\d \\(\\)]{9,12})$";
		Pattern p = Pattern.compile(japanesePhoneRegex);
		Matcher m = p.matcher(phone);

		return m.matches();
	}

	public static final boolean isValidAddress(String address) {
		if (address == null || address.isEmpty()) return false;

		// Change minimum address length to check wheter the input address is acceptable
		return address.length() >= 5;
	}

	public static final boolean isValidImageUrl(String imageUrl) {
		if (imageUrl == null) return false;

		if (imageUrl.isEmpty()) return true;

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

		if (!isValidImageUrl(hotelInfo.getImagePath())) {
			errors.add("Invalid image path format: " + hotelInfo.getImagePath());
		}

		if (!isValidPhoneNumber(hotelInfo.getPhone())) {
			errors.add("Invalid phone number: " + hotelInfo.getPhone());
		}

		return errors;
	}
}
