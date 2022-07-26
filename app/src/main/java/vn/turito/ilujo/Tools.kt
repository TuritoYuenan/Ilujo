package vn.turito.ilujo

import vn.turito.ilujo.converter.*

object Tools {

	val Instruments = listOf(
//		Tool("Calculator", R.drawable.ic_tool_calculator, Calculator()),
//		Tool("Lux Meter", R.drawable.ic_tool_luxmeter, ),
//		Tool("Sound Meter", R.drawable.ic_tool_soundmeter, ),
//		Tool("Vibrometer", R.drawable.ic_tool_vibrometer, ),
		Tool("Phone Info", R.drawable.ic_tool_info, PhoneInfo())
	)

	val Converters = listOf(
		Tool("Area", R.drawable.ic_tool_conv_area, AreaConverter())
	)
}
