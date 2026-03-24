$content = Get-Content 'c:\Users\Pariente\AndroidStudioProjects\ringtone\app\src\main\res\layout\activity_main.xml' -Raw -Encoding UTF8

$content = $content.Replace('android:layout_width="0dp"`n                android:layout_weight="1"', "android:layout_width=`"0dp`"`r`n                android:layout_weight=`"1`"")

# Check if we already inserted share buttons, to avoid duplicates
if (-not $content.Contains("btn_share_1")) {
    for ($i = 1; $i -le 10; $i++) {
        $search = "android:id=`"@+id/btn_$i`""
        $idx = $content.IndexOf($search)
        if ($idx -ge 0) {
            $endIdx = $content.IndexOf("</LinearLayout>", $idx)
            if ($endIdx -ge 0) {
                $buttons = @"
            <ImageButton
                android:id="@+id/btn_share_$i"
                android:layout_width="45dp"
                android:layout_height="45dp"
                android:src="@drawable/share"
                android:scaleType="centerInside"
                android:background="?attr/selectableItemBackground"
                android:layout_marginStart="8dp" />

            <ImageButton
                android:id="@+id/btn_blue_$i"
                android:layout_width="45dp"
                android:layout_height="45dp"
                android:src="@drawable/blue"
                android:scaleType="centerInside"
                android:background="?attr/selectableItemBackground"
                android:layout_marginStart="8dp" />
        </LinearLayout>
"@
                $content = $content.Substring(0, $endIdx) + $buttons + $content.Substring($endIdx + 15)
            }
        }
    }
}

Set-Content 'c:\Users\Pariente\AndroidStudioProjects\ringtone\app\src\main\res\layout\activity_main.xml' $content -Encoding UTF8
Write-Output "Fixed activity_main.xml"
