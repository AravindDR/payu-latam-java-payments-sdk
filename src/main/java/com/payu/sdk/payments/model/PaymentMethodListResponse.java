/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 developers-payu-latam
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.payu.sdk.payments.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.payu.sdk.exceptions.PayUException;
import com.payu.sdk.exceptions.SDKException.ErrorCode;
import com.payu.sdk.model.PaymentMethodComplete;
import com.payu.sdk.model.response.Response;

/**
 * Represents a payment methods list response in the PayU SDK.
 *
 * @author PayU Latam
 * @since 1.0.0
 * @version 1.0.0, 21/08/2013
 */
@XmlRootElement(name = "paymentMethodsResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentMethodListResponse extends Response {

	/** The generated serial version Id */
	private static final long serialVersionUID = -7195664286168296034L;
	/** the payment method list. */
	@XmlElementWrapper(name = "paymentMethods")
	@XmlElement(name = "paymentMethodComplete")
	private List<PaymentMethodComplete> paymentMethods;

	/**
	 * Returns the payment method list
	 *
	 * @return the paymentMethods
	 */
	public List<PaymentMethodComplete> getPaymentMethods() {

		return paymentMethods;
	}

	/**
	 * Sets the payment method list
	 *
	 * @param paymentMethods
	 *            the paymentMethods to set
	 */
	public void setPaymentMethods(List<PaymentMethodComplete> paymentMethods) {

		this.paymentMethods = paymentMethods;
	}

	/**
	 * Converts a xml string into a payment method list response object
	 *
	 * @param xml
	 *            The object in a xml format
	 * @return The payment method list response object
	 * @throws PayUException
	 */
	public static PaymentMethodListResponse fromXml(String xml)
			throws PayUException {

		try {
			return (PaymentMethodListResponse) fromBaseXml(
					new PaymentMethodListResponse(), xml);
		} catch (Exception e) {
			throw new PayUException(ErrorCode.XML_DESERIALIZATION_ERROR, e);
		}
	}

}
