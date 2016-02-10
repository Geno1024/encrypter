package com.geno.encrypter;

import android.util.Base64;

public class Methods
{
	public static class Encode
	{
		public static String random(String s)
		{
			return random(s, System.currentTimeMillis());
		}

		public static String random(String s, long seed)
		{
			switch ((int) seed % 16)
			{
				case 0x0:
					return Base64(s);
				case 0x1:
					return rot13(s);
				case 0x2:
					return ASCII(s);
				case 0x3:
					return ASCIIWithDiffInDec(s);
				default:
					return s;
			}
		}

		public static String Base64(String s)
		{
			return Base64.encodeToString(s.getBytes(), Base64.DEFAULT);
		}

		public static String rot13(String s)
		{
			String out = "";
			for (char c : s.toCharArray())
				out += Character.isLetterOrDigit(c) ? (Character.isDigit(c) ? (c > '4' ? c - 5 : c + 5) : (Character.isUpperCase(c) ? (c > 'M' ? c - 13 : c + 13) : (c > 'm' ? c - 13 : c + 13))) : c;
			return out;
		}

		public static String ASCII(String s)
		{
			String out = "";
			for (char c : s.toCharArray())
				out += Integer.toHexString(c);
			return out;
		}

		public static String ASCIIWithDiffInDec(String s)
		{
			String out = "";
			for (char c : s.toCharArray())
				out += (c - 32) + "";
			return out;
		}
	}
}
